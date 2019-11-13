package com.projeto.integrador.clientdesktop.controllers.reports;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.projeto.integrador.clientdesktop.collections.ProjectSeasonCollection;
import com.projeto.integrador.clientdesktop.models.SolarRadiation;
import com.projeto.integrador.clientdesktop.resources.ReportResource;
import com.projeto.integrador.clientdesktop.resources.SolarRadiationResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;

@Controller
public class ListReportsController implements Initializable {

  @Autowired
  private ReportResource reportResource;

  @Autowired
  private SolarRadiationResource solarRadiationResource;

  private JsonNode reportJsonData;

  private LocalDate startAt;
  private LocalDate endAt;
  private SolarRadiation solarRadiation;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    endAt = LocalDate.now();
    endAt = endAt.withDayOfMonth(endAt.lengthOfMonth());
    startAt = endAt.minusMonths(5).withDayOfMonth(1);

    setFilterFields();
    getReportData();
    buildCharts();
  }

  private void setFilterFields() {
    startAtInput.setValue(startAt);
    endAtInput.setValue(endAt);

    ObservableList<SolarRadiation> solarRadiationOptions = FXCollections.observableArrayList(solarRadiationResource.getAll());
    solarRadiationOptions.add(0, null);
    solarRadiationComboBox.setItems(solarRadiationOptions);
  }

  private void getReportData() {
    reportJsonData = reportResource.getAll(startAt, endAt, solarRadiation);
  }

  private void buildCharts() {
    pane1.getChildren().clear();
    pane1.getChildren().add(projectsByRoomsPieChart());
    pane2.getChildren().clear();
    pane2.getChildren().add(projectsBySeasonPieChart());
    pane3.getChildren().clear();
    pane3.getChildren().add(projectsByMonthLineChart());
  }

  @FXML
  private void submit(ActionEvent event) throws IOException {
    startAt = startAtInput.getValue();
    endAt = endAtInput.getValue();
    solarRadiation = (SolarRadiation) solarRadiationComboBox.getSelectionModel().getSelectedItem();

    getReportData();
    buildCharts();
  }

  private PieChart projectsByRoomsPieChart() {
    PieChart pie = new PieChart();
    pie.setTitle("Projetos por cômodo");

    ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();

    JsonNode projectsByRoomsJsonData = reportJsonData.get("projects_by_rooms");

    Iterator<Entry<String, JsonNode>> iterator = projectsByRoomsJsonData.fields();

    while (iterator.hasNext()) {
      Entry<String, JsonNode> entry = iterator.next();
      String key = entry.getKey();
      int value = entry.getValue().asInt();

      Data data = new PieChart.Data(key, value);

      pieData.addAll(data);
    }

    if (projectsByRoomsJsonData.size() == 0) {
      Data data = new PieChart.Data("Nenhum projeto foi encontrado", 0);
      pieData.addAll(data);
    } else {
      pieData.forEach(data ->
        data.nameProperty().bind(
          Bindings.concat(data.getName(), " cômodo: ", data.pieValueProperty().getValue().intValue(), " projetos")
        )
      );
    }

    pie.setData(pieData);

    return pie;
  }

  private PieChart projectsBySeasonPieChart() {
    PieChart pie = new PieChart();
    pie.setTitle("Projetos por estação");

    ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();

    JsonNode projectsBySeasonJsonData = reportJsonData.get("projects_by_season");

    Iterator<Entry<String, JsonNode>> iterator = projectsBySeasonJsonData.fields();

    while (iterator.hasNext()) {
      Entry<String, JsonNode> entry = iterator.next();
      String key = entry.getKey();
      int value = entry.getValue().asInt();

      ProjectSeasonCollection season = ProjectSeasonCollection.findByValue(key);

      Data data = new PieChart.Data(season.toString(), value);

      pieData.addAll(data);
    }

    if (projectsBySeasonJsonData.size() == 0) {
      Data data = new PieChart.Data("Nenhum projeto foi encontrado", 0);
      pieData.addAll(data);
    } else {
      pieData.forEach(data ->
        data.nameProperty().bind(
          Bindings.concat(data.getName(), ": ", data.pieValueProperty().getValue().intValue(), " projetos")
        )
      );
    }

    pie.setData(pieData);

    return pie;
  }

  private XYChart<CategoryAxis, NumberAxis> projectsByMonthLineChart() {
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    LineChart line = new LineChart<>(xAxis, yAxis);

    line.setTitle("Projetos criados por mês");
    line.setData(projectsByMonthLineChartData(reportJsonData.get("projects_by_months")));

    return line;
  }

  private ObservableList<Series<String, Integer>> projectsByMonthLineChartData(JsonNode projectsByMonthsJsonData) {
    ObservableList<Series<String, Integer>> data = FXCollections.observableArrayList();

    Series<String, Integer> serie = new Series<>();

    serie.setName("Projetos");

    LocalDate date = startAt;

    while(date.isBefore(endAt)) {
      int value = 0;

      String key = date.format(DateTimeFormatter.ofPattern("YYYY-MM"));

      if (projectsByMonthsJsonData.has(key)) {
        value = projectsByMonthsJsonData.get(key).asInt();
      }

      serie.getData().add(new XYChart.Data<String, Integer> (getMonthTranslated(date.getMonth().name()), value));

      date = date.plusMonths(1);
    }

    data.addAll(serie);

    return data;
  }

  private String getMonthTranslated(String month) {
    Map <String, String> i18n = new HashMap<String, String>();
    i18n.put("january", "Janeiro");
    i18n.put("february", "Fevereiro");
    i18n.put("march", "Março");
    i18n.put("april", "Abril");
    i18n.put("may", "Maio");
    i18n.put("june", "Junho");
    i18n.put("july", "Julho");
    i18n.put("august", "Agosto");
    i18n.put("september", "Setembro");
    i18n.put("october", "Outubro");
    i18n.put("november", "Novembro");
    i18n.put("december", "Dezembro");

    return i18n.get(month.toLowerCase());
  }

  @FXML
  private DatePicker startAtInput, endAtInput;

  @FXML
  private ComboBox<SolarRadiation> solarRadiationComboBox;

  @FXML
  private StackPane pane1, pane2, pane3;

}

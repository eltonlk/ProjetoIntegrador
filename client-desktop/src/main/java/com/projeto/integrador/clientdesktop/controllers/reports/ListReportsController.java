package com.projeto.integrador.clientdesktop.controllers.reports;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.projeto.integrador.clientdesktop.collections.ProjectSeasonCollection;
import com.projeto.integrador.clientdesktop.resources.ReportResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;

@Controller
public class ListReportsController implements Initializable {

  @Autowired
  private ReportResource reportResource;

  private JsonNode reportJsonData;

  private LocalDate start_at;
  private LocalDate end_at;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    start_at = LocalDate.parse("2019-06-25").withDayOfMonth(1);
    end_at = LocalDate.parse("2019-11-10").withDayOfMonth(28);

    reportJsonData = reportResource.getAll(start_at, end_at, null);

    pane1.getChildren().add(projectsByRoomsPieChart());
    pane2.getChildren().add(projectsBySeasonPieChart());
    pane3.getChildren().add(projectsByMonthLineChart());
  }

  private PieChart projectsByRoomsPieChart() {
    PieChart pie = new PieChart();
    pie.setTitle("Projetos por cômodo");

    ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();

    JsonNode projectsByRoomsJsonData = reportJsonData.get("projects_by_rooms");

    if (projectsByRoomsJsonData != null) {
      Iterator<Entry<String, JsonNode>> iterator = projectsByRoomsJsonData.fields();

      while (iterator.hasNext()) {
        Entry<String, JsonNode> entry = iterator.next();
        String key = entry.getKey();
        int value = entry.getValue().asInt();

        Data data = new PieChart.Data(key + " cômodo (" + value + " projetos)", value);

        pieData.addAll(data);
      }
    }

    pie.setData(pieData);

    return pie;
  }

  private PieChart projectsBySeasonPieChart() {
    PieChart pie = new PieChart();
    pie.setTitle("Projetos por estação");

    ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();

    JsonNode projectsByRoomsJsonData = reportJsonData.get("projects_by_season");

    if (projectsByRoomsJsonData != null) {
      Iterator<Entry<String, JsonNode>> iterator = projectsByRoomsJsonData.fields();

      while (iterator.hasNext()) {
        Entry<String, JsonNode> entry = iterator.next();
        String key = entry.getKey();
        int value = entry.getValue().asInt();

        ProjectSeasonCollection season = ProjectSeasonCollection.findByValue(key);

        Data data = new PieChart.Data(season.toString() + " (" + value + " projetos)", value);

        pieData.addAll(data);
      }
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

  private ObservableList<XYChart.Series<String, Double>> projectsByMonthLineChartData(JsonNode projectsByRoomsJsonData) {
    ObservableList<XYChart.Series<String, Double>> data = FXCollections.observableArrayList();

    Series<String, Double> serie = new Series<>();

    serie.setName("Projetos");

    LocalDate date = start_at;

    while(date.isBefore(end_at)) {
      double value = 0;

      String key = date.format(DateTimeFormatter.ofPattern("YYYY-MM"));

      if (projectsByRoomsJsonData.has(key)) {
        value = projectsByRoomsJsonData.get(key).asDouble();
      }

      serie.getData().add(new XYChart.Data<> (date.getMonth().name(), value));

      date = date.plusMonths(1);
    }

    data.addAll(serie);

    return data;
  }

  @FXML
  private StackPane pane1, pane2, pane3;

}

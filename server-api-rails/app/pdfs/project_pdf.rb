class ProjectPdf
  include Prawn::View

  attr_accessor :project

  def initialize project
    @project = project

    content
  end

  def content
    text "Projeto", align: :center

    move_down 5

    text project.name, align: :center, size: 26

    move_down 20

    text "Estação: <b>#{project.season}</b>", inline_format: true
    move_down 5
    text "Temperatura Externa: <b>#{project.external_temperature}</b>", inline_format: true
    move_down 5
    text "Temperatura Interna: <b>#{project.internal_temperature}</b>", inline_format: true
    move_down 5
    text "Radiação Solar: <b>#{project.solar_radiation.name}</b>", inline_format: true

    move_down 20

    text "<b>Cômodos:</b>", inline_format: true
    move_down 5

    project.rooms.each do |room|
      text "#{room.name} - <i>carga de calor</i>: <b>#{room.heat_load}</b>", inline_format: true
      move_down 5
    end
  end
end

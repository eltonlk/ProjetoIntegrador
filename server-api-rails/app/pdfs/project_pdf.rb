class ProjectPdf
  include Prawn::View

  attr_accessor :project

  def initialize project
    @project = project

    content
  end

  def content
    text "Projeto: #{project.name}"
    text "Estação: #{project.season}"
    text "Temperatura Externa: #{project.external_temperature}"
    text "Temperatura Interna: #{project.internal_temperature}"
    text "Radiação Solar: #{project.solar_radiation.name}"

    text "Cômodos:"

    project.rooms.each do |room|
      text "#{room.name} - carga de calor: #{room.heat_load}"
    end
  end
end

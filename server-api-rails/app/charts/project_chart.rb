class ProjectChart
  attr_accessor :filter_object

  def initialize filter_object
    self.filter_object = filter_object
  end

  def configurations
    {
      projects_by_rooms: projects_by_rooms,
      projects_by_season: projects_by_season,
      projects_by_months: projects_by_months,
      used_materials: used_materials
    }
  end

  private
    def projects_by_rooms
      ProjectsByRoom.by_period(filter_object.date_from, filter_object.date_to)
        .by_solar_radiation(filter_object.solar_radiation_id)
        .group(:rooms)
        .count
    end

    def projects_by_season
      ProjectsBySeason.by_period(filter_object.date_from, filter_object.date_to)
        .by_solar_radiation(filter_object.solar_radiation_id)
        .group(:season)
        .count
    end

    def projects_by_months
      ProjectsByYearAndMonth.by_period(filter_object.date_from, filter_object.date_to)
        .by_solar_radiation(filter_object.solar_radiation_id)
        .group_by{ |project| project.created_at.strftime("%Y-%m") }
        .map{ |date, projects| [ date, projects.count ] }
        .to_h
    end

    def used_materials
      UsedMaterial.by_period(filter_object.date_from, filter_object.date_to)
        .by_solar_radiation(filter_object.solar_radiation_id)
        .group(:material)
        .count
        .map{ |material, projects_count| [ material.name, projects_count ] }
        .to_h
    end
end

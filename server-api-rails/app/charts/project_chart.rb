class ProjectChart
  attr_accessor :projects, :projects_by_rooms, :projects_by_season, :projects_by_months

  def initialize projects
    self.projects = projects

    set_resource
  end

  def configurations
    {
      projects_by_rooms: projects_by_rooms,
      projects_by_season: projects_by_season,
      projects_by_months: projects_by_months
    }
  end

private
    def set_resource
      self.projects_by_rooms = projects.group_by{ |project| project.rooms.count }
        .map{ |rooms_count, projects| [ rooms_count, projects.count ] }
        .to_h

      self.projects_by_season = projects.group_by(&:season)
        .map{ |season, projects| [ season, projects.count ] }
        .to_h

      self.projects_by_months = projects.group_by{ |project| project.created_at.strftime("%Y-%m") }
        .map{ |date, projects| [ date, projects.count ] }
        .to_h
    end
end

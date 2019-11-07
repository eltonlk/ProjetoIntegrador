class ProjectQuery
  def initialize relation = Project
    @relation = relation.extend Scopes
  end

  def filter filter_object
    @relation
      .by_period(filter_object.date_from, filter_object.date_to)
      .by_solar_radiation(filter_object.solar_radiation_id)
      .order(name: :desc)
  end

  module Scopes
    def by_period date_from, date_to
      return all if date_from.blank? and date_to.blank?

      if date_from.present? and date_to.present?
        where created_at: date_from..date_to
      elsif date_from.present?
        where "created_at >= ?", date_from
      else
        where "created_at <= ?", date_to
      end
    end

    def by_solar_radiation solar_radiation
      return all if solar_radiation.blank?

      where solar_radiation_id: solar_radiation
    end
  end
end

class ProjectsByRoom < ActiveRecord::Base
  self.primary_key = :project_id

  def readonly?
    true
  end

  def self.by_period date_from, date_to
    return all if date_from.blank? and date_to.blank?

    if date_from.present? and date_to.present?
      where created_at: date_from..date_to
    elsif date_from.present?
      where "created_at >= ?", date_from
    else
      where "created_at <= ?", date_to
    end
  end

  def self.by_solar_radiation solar_radiation
    return all if solar_radiation.blank?

    where solar_radiation_id: solar_radiation
  end
end

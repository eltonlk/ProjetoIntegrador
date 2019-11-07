class ReportFilterForm < BaseForm
    attribute :date_from         , type: Date   , default: -> { Time.current.to_date.beginning_of_month - 5.months }
    attribute :date_to           , type: Date   , default: -> { Time.current.to_date.end_of_month }
    attribute :solar_radiation_id, type: Integer
  end

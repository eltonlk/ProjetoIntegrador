class ReportsController < ApplicationController
  before_action do
    authorize :reports
  end

  before_action :set_filter

  # GET /reports
  def index
    @projects = ProjectQuery.new.filter @filter_form

    render json: ProjectChart.new(@projects).configurations
  end

  private
    def set_filter
      @filter_form = ReportFilterForm.new params.permit(:date_from, :date_to, :solar_radiation_id)
    end
end

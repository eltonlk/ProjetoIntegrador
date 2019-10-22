class AuditsController < ApplicationController
  before_action do
    authorize :audits
  end

  # GET /audits
  def index
    @audits = Audit.all

    render json: @audits
  end
end

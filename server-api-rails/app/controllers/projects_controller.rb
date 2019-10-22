class ProjectsController < ApplicationController
  before_action :set_project, only: [ :show, :update, :destroy ]

  def index
    @projects = Project.all

    render json: @projects, status: :ok
  end

  def show
    render json: @project, status: :ok
  end

  def create
    @project = Project.create! project_params

    render json: @project, status: :created
  end

  def update
    @project.update project_params

    head :no_content
  end

  def destroy
    @project.destroy

    head :no_content
  end

  private
    def project_params
      params.require(:project).permit(:name, :season, :external_temperature, :internal_temperature, :solar_radiation_id)
    end

    def set_project
      @project = Project.find params.require(:id)
    end
end

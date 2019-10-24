class ProjectsController < ApplicationController
  before_action do
    authorize :projects
  end

  before_action :set_project, only: [ :show, :update, :destroy ]

  # GET /projects
  def index
    @projects = Project.all

    render json: @projects, include: [ :solar_radiation, rooms: { include: { faces: { include: { components: { include: [ :color, component_materials: { include: :material } ] } } } } } ]
  end

  # GET /projects/1
  def show
    render json: @project, include: [ :solar_radiation, rooms: { include: { faces: { include: { components: { include: [ :color, component_materials: { include: :material } ] } } } } } ]
  end

  # POST /projects
  def create
    @project = Project.new project_params

    if @project.save
      render json: @project, include: [ :solar_radiation, :rooms ], status: :created, location: @project
    else
      render json: @project.errors, include: [ :solar_radiation, :rooms ], status: :unprocessable_entity
    end
  end

  # PATCH/PUT /projects/1
  def update
    if @project.update project_params
      render json: @project, include: [ :solar_radiation, rooms: { include: { faces: { include: { components: { include: [ :color, component_materials: { include: :material } ] } } } } } ]
    else
      render json: @project.errors, include: [ :solar_radiation, rooms: { include: { faces: { include: { components: { include: [ :color, component_materials: { include: :material } ] } } } } } ], status: :unprocessable_entity
    end
  end

  # DELETE /projects/1
  def destroy
    @project.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_project
      @project = Project.find params[:id]
    end

    # Only allow a trusted parameter "white list" through.
    def project_params
      params.permit(:name, :season, :external_temperature, :internal_temperature, :solar_radiation_id)
    end
end

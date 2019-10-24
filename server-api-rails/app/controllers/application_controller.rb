class ApplicationController < ActionController::API
  include Pundit

  before_action :authenticate_request
  before_action :auditing_enabled

  def current_user
    @current_user = AuthorizationService.call(request.headers).result
  end

  private
    def authenticate_request
      render json: { error: 'Not Authorized' }, status: 401 unless current_user
    end

    def auditing_enabled
      enabled = Option.find_by(name: 'audits').try(:value) != 'disabled'

      if params[:controller] == 'options' and params[:name] == 'audits'
        enabled = true
      end

      Audited.auditing_enabled = enabled
    end
end

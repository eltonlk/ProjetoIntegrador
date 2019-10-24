class ApplicationController < ActionController::API
  include Pundit

  before_action :authenticate_request
  before_action :auditing_enabled

  attr_reader :current_user

  private
    def authenticate_request
      @current_user = AuthorizationService.call(request.headers).result

      render json: { error: 'Not Authorized' }, status: 401 unless @current_user
    end

    def auditing_enabled
      enabled = Option.find_by(name: 'audits').try(:value) != 'disabled'

      if params[:controller] == 'options' and params[:name] == 'audits'
        enabled = true
      end

      Audited.auditing_enabled = enabled
    end
end

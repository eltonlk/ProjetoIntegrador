class SessionController < ActionController::API
  def create
    service = AuthenticateService.call(params[:username], params[:password])

    if service.success?
      render json: { token: service.result }
    else
      render json: { error: service.errors }, status: :unauthorized
    end
  end
end

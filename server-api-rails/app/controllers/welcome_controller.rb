class WelcomeController < ActionController::API
  def index
    render json: { message: 'Projeto Integrador Api' }
  end
end

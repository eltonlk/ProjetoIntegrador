require 'jwt'

class AuthenticateService
  prepend SimpleCommand

  def initialize username, password
    @username = username
    @password = password
  end

  def call
    JWT.encode({ user_id: user.id }, nil, 'none') if user
  end

  private
    attr_accessor :username, :password

    def user
      user = User.find_by username: username

      return user if user && user.authenticate(password)

      errors.add :user_authentication, 'invalid credentials'

      nil
    end
end

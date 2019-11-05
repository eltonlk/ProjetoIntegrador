ActionMailer::Base.smtp_settings = Rails.application.credentials.mail || {}

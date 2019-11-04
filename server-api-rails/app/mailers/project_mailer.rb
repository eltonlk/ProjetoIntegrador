class ProjectMailer < ApplicationMailer

  def send_mail project, email
    @project = project

    mail to: email, subject: "Dados do Projeto #{@project.name}"
  end

end

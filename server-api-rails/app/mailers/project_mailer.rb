class ProjectMailer < ApplicationMailer

  def send_mail project, email
    @project = project

    pdf = ProjectPdf.new @project

    attachments['Projeto.pdf'] = {
      mime_type: 'application/pdf',
      content: project.render
    }

    mail to: email, subject: "Dados do Projeto #{@project.name}"
  end

end

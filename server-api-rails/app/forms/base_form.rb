class BaseForm
  include ActiveAttr::Model

  def self.from_params params = {}
    params = params.reject { |k, v| v.blank? }

    form = self.new

    if form.respond_to? :localized
      form.localized params
    else
      form.attributes = params
    end

    form
  end

  def params_localized
    params = {}

    attributes.keys.each do |attribute|
      params[attribute.to_sym] = localized.send attribute
    end

    params
  end
end

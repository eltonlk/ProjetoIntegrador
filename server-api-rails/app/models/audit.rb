class Audit < Audited::Audit
  default_scope -> { order created_at: :desc }
end

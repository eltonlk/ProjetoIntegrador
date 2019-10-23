FROM ruby:2.6.3

RUN apt-get update -qq && apt-get install -y build-essential libpq-dev postgresql-client

RUN mkdir /usr/src/api
VOLUME /usr/src/api

# Copy the main application.
COPY . /usr/src/api

WORKDIR /usr/src/api

RUN gem install bundler -v 2.0.2
RUN bundle install

# Add a script to be executed every time the container starts.
COPY entrypoint.sh /usr/bin/
RUN chmod +x /usr/bin/entrypoint.sh
ENTRYPOINT ["entrypoint.sh"]

# Expose port 3000 to the Docker host, so we can access it
# from the outside.
EXPOSE 3000

# The main command to run when the container starts. Also
# tell the Rails dev server to bind to all interfaces by
# default.
CMD ["bundle", "exec", "rails", "server", "-b", "0.0.0.0"]

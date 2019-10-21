FROM ruby:2.5

# Install dependencies
RUN apt-get update -qq && apt-get install -y apt-utils nodejs git postgresql-client

# Workspace
# RUN mkdir /projeto-integrador
# WORKDIR /projeto-integrador
COPY . /usr/src/projeto-integrador
VOLUME /usr/src/projeto-integrador
EXPOSE 4567
WORKDIR /usr/src/projeto-integrador


# Copy Gemfile
# COPY Gemfile /projeto-integrador/Gemfile
# COPY Gemfile.lock /projeto-integrador/Gemfile.lock

# Update bundler && install
RUN gem install bundler -v 2.0.2
RUN bundle install

# Copy projeto folder
# COPY . /projeto-integrador

# Add a script to be executed every time the container starts.
COPY entrypoint.sh /usr/bin/
RUN chmod +x /usr/bin/entrypoint.sh
ENTRYPOINT ["entrypoint.sh"]
EXPOSE 3000

# Start the main process.
CMD ["rails", "server", "-b", "0.0.0.0"]

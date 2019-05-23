FROM ibmcom/websphere-traditional:9.0.0.11

COPY --chown=was:root FizzBuzzEnterpriseEdition.war /work/app/FizzBuzzEnterpriseEdition.war
COPY --chown=was:root installapp.py /work/config
RUN /work/configure.sh
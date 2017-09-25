#!/bin/bash

mvn clean install -Pverify -Dgalenium.report.sparse=true -Dgalenium.report.galen.errorsOnly=true

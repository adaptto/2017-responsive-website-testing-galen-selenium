#!/bin/bash

mvn install -Pverify -Dgalenium.report.sparse=true -Dgalenium.report.galen.errorsOnly=true

#!/bin/sh
${JAVA_HOME}/bin/java -cp /home/ebrjohn/projects/java/UnitConverter com.johnson.UnitConverter.UnitConverterMain $@ &
/usr/bin/java -cp /home/notroot/projects/java/UnitConverter com.johnson.UnitConverter.UnitConverterMain $@ &

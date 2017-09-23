#!/bin/bash

echo "copy text samples";
cp -rv target/sampled/texts/text src/test/resources/galen/specs/
echo "copy image samples";
cp -rv target/sampled/images src/test/resources/galen/specs/


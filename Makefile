# type 'make -s list' to see list of targets.

run-app:
	echo 'No application to run for this project'

test-app:
	./gradlew clean testHeadless

test-app-ci:
	npm install phantomjs
	./gradlew clean testHeadless -Dgeb.env=functional01 -Dtest.env=functional01
	tar cvf eva-presentation-test-results-$(BUILD_ID).tar.gz build/reports/tests

test-open-results:
	open build/reports/tests/index.html

setup-app:
	echo 'No configuration to setup for this project'

.PHONY: no_targets__ list
no_targets__:
list:
	sh -c "$(MAKE) -p no_targets__ | awk -F':' '/^[a-zA-Z0-9][^\$$#\/\\t=]*:([^=]|$$)/ {split(\$$1,A,/ /);for(i in A)print A[i]}' | grep -v '__\$$' | sort"

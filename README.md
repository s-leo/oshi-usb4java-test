# oshi-usb4java-test

This repository contains the test code necessary to replicate a SIGSEGV issue on Eclipse Kura when both _usb4java_ and 
_oshi_ are used and USB devices get attached/detached.

# Build

Build the project with `mvn clean install`.

# Test

In order to replicate the issue, a 20-seconds `Thread.sleep()` has been put to ensure that oshi runs only after 
usb4java services have been called, as this order seems to be the triggering factor for this issue.  
When the `Thread.sleep()` ends, this message will be printed to standard output:  
`OshiTestService - SLEEP END`  
after which, attaching or detaching any USB device will cause a SIGSEGV fatal error.

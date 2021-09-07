DESCRIPTION = "This software is a non-official extension to the Flutter SDK to build and debug \
               Flutter apps for Embedded Linux devices using flutter-embedded-linux, which is \
               the flutter embedder for eLinux."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=647d87ee0850d0ee715550d324dd447c"

SRC_URI = "git://github.com/sony/flutter-elinux.git;protocol=https;branch=main"

# Describe how to keep in sync with engine
SRCREV = "dcce678c32f710f4659ea06e6257657b9d782b70"

S = "${WORKDIR}/git"

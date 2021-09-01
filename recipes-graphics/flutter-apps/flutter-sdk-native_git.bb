SUMMARY = "Flutter makes it easy and fast to build beautiful apps for mobile and beyond."
DESCRIPTION = "Flutter is Google's SDK for crafting beautiful, fast user experiences for \
               mobile, web, and desktop from a single codebase. Flutter works with \
               existing code, is used by developers and organizations around the world, \
               and is free and open source."
AUTHOR = "Google"
HOMEPAGE = "https://flutter.dev/"
BUGTRACKER = "https://github.com/flutter/flutter/issues"
SECTION = "graphics"
CVE_PRODUCT = ""

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1d84cf16c48e571923f837136633a265"

FLUTTER_CHANNEL ??= "dev"

DEPENDS += "curl-native unzip-native"

SRC_URI = "git://github.com/flutter/flutter;protocol=https;branch=${FLUTTER_CHANNEL} \
           file://ca-certificates.crt"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit native

do_compile() {
    export CURL_CA_BUNDLE=${WORKDIR}/ca-certificates.crt
    export PATH=${S}/bin:$PATH
    export PUB_CACHE=${S}/.pub-cache
    
    flutter channel ${FLUTTER_CHANNEL}
    bbnote `flutter doctor -v`
}

do_install() {
    install -d ${D}${datadir}/flutter/sdk
    cp -rTv ${S}/. ${D}${datadir}/flutter/sdk
}

FILES:${PN}-dev = "${datadir}/flutter/sdk/*"

INSANE_SKIP:${PN}-dev = "already-stripped"

BBCLASSEXTEND = "native nativesdk"

# vim:set ts=4 sw=4 sts=4 expandtab:

DEPENDS = "curl-native unzip-native"

include flutter-elinux.inc

SRC_URI:append += "file://ca-certificates.crt"

inherit native

do_compile() {
    export CURL_CA_BUNDLE=${WORKDIR}/ca-certificates.crt
    export PATH=${S}/bin:$PATH
    export PUB_CACHE=${S}/.pub-cache
    bbnote `flutter-elinux --version`
}

do_install() {
    install -d ${D}${datadir}/flutter-elinux
    cp -rTv  ${S}/. ${D}${datadir}/flutter-elinux
}

FILES:${PN}-dev = "${datadir}/flutter-elinux/*"

INSANE_SKIP:${PN} = "already-stripped"

BBCLASSEXTEND = "native"
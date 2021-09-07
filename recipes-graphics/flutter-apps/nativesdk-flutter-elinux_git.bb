include flutter-elinux.inc

inherit nativesdk

SRC_URI:append += "file://flutter.sh"

do_install() {
    install -d ${D}${SDKPATHNATIVE}/opt
    cp -R --no-dereference --preserve=mode,links ${S} ${D}${SDKPATHNATIVE}/opt/flutter-elinux

    install -d ${D}${SDKPATHNATIVE}/environment-setup.d
    install -m0644 ${WORKDIR}/flutter.sh ${D}${SDKPATHNATIVE}/environment-setup.d/
}

FILES:${PN} = "${SDKPATHNATIVE}/opt/flutter-elinux ${SDKPATHNATIVE}/environment-setup.d"
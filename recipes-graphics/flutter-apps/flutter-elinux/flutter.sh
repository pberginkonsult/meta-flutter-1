export PATH=${PATH}:${OECORE_NATIVE_SYSROOT}/opt/flutter-elinux/bin
export PUB_CACHE=${OECORE_NATIVE_SYSROOT}/opt/flutter-elinux/.pub-cache
export FLUTTER_SDK=${OECORE_NATIVE_SYSROOT}/opt/flutter-elinux/flutter

echo "Will run flutter-engine --version."
echo "If this is the first time Flutter SDK will be downloaded and populated."
flutter-elinux --version
if [ ! -d ${FLUTTER_SDK}/bin/cache/artifacts/engine/linux-arm64-release ]; then
    echo "Will unpack artifacts from flutter_engine build"
    unzip  ${OECORE_TARGET_SYSROOT}/usr/share/flutter/engine_sdk.zip -d ${FLUTTER_SDK}/bin/cache/artifacts/engine
    mv ${FLUTTER_SDK}/bin/cache/artifacts/engine/sdk ${FLUTTER_SDK}/bin/cache/artifacts/engine/linux-arm64-release
fi

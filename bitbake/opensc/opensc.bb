DESCRIPTION = "A set of libraries and utilities to work with smart cards"
HOMEPAGE = "http://www.opensc-project.org/opensc"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

DEPENDS = "pcsc-lite openssl"

LEAD_SONAME = "libopensc"

LIBS += "-ldl"

SRC_URI = "git://github.com/frankmorgner/OpenSC.git;"
SRCREV  = "d818628bf9c62c750710649b0b234bc71eec4ee9"
S       = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-pcsc=yes LIBS=-ldl \
                --with-pcsc-provider=${libdir}/libpcsclite.so.1 \
               "

#FIXME
FILES_${PN} += "${libdir}/pkcs11-spy.so \
                ${libdir}/opensc-pkcs11.so \
                ${libdir}/onepin-opensc-pkcs11.so \
                ${libdir}/pkcs11/pkcs11-spy.so \
                ${libdir}/pkcs11/opensc-pkcs11.so \
                ${libdir}/pkcs11/onepin-opensc-pkcs11.so \
                "
FILES_${PN}-dbg += "${libdir}/pkcs11/.debug"

SRC_URI[md5sum] = "62fe8d3ed1864556c1970d7c23d8d58e"
SRC_URI[sha256sum] = "e9b5812dd8024484c6bb7400fb3e638aca2e9b112a7ffb161c300fe2260b28c8"
#! /bin/sh
git clone -b master $(pwd) src
cd src
lein impress
cp -rL public/* ../
cd ..
rm -rf src

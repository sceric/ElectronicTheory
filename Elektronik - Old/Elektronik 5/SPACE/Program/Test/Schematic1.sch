*version 9.1 546044994
u 42
HB? 2
R? 4
? 4
V? 2
C? 2
@libraries
@analysis
.STMLIB Schematic1.stl
@targets
@attributes
@translators
a 0 u 13 0 0 0 hln 100 PCBOARDS=PCB
a 0 u 13 0 0 0 hln 100 PSPICE=PSPICE
a 0 u 13 0 0 0 hln 100 XILINX=XILINX
@setup
unconnectedPins 0
connectViaLabel 0
connectViaLocalLabels 0
NoStim4ExtIFPortsWarnings 1
AutoGenStim4ExtIFPorts 1
@index
pageloc 1 0 1958 
@status
n 2402 110:04:28:23:32:22;1275082342 e 
s 0 110:04:28:23:31:35;1275082295 e 
c 110:04:28:23:32:19;1275082339
*page 1 0 970 720 iA
@ports
port 6 GND_EARTH 160 170 h
@parts
part 11 R 290 90 h
a 0 sp 0 0 0 10 hlb 100 PART=R
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=RC05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=R1
a 0 ap 9 0 15 0 hln 100 REFDES=R1
part 39 C 390 90 h
a 0 sp 0 0 0 10 hlb 100 PART=C
a 0 s 0:13 0 0 0 hln 100 PKGTYPE=CK05
a 0 s 0:13 0 0 0 hln 100 GATE=
a 0 a 0:13 0 0 0 hln 100 PKGREF=C1
a 0 ap 9 0 15 0 hln 100 REFDES=C1
part 34 VSRC 160 110 h
a 0 a 0:13 0 0 0 hln 100 PKGREF=V1
a 1 ap 9 0 20 10 hcn 100 REFDES=V1
a 1 u 0 0 0 0 hcn 100 AC=12
a 1 u 0 0 0 0 hcn 100 DC=0
part 1 titleblk 970 720 h
a 1 s 13 0 350 10 hcn 100 PAGESIZE=A
a 1 s 13 0 180 60 hcn 100 PAGETITLE=
a 1 s 13 0 340 95 hrn 100 PAGECOUNT=1
a 1 s 13 0 300 95 hrn 100 PAGENO=1
part 28 nodeMarker 370 90 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=1
a 0 sp 0 0 0 0 hln 100 COLOR=BRIGHTGREEN
part 30 nodeMarker 470 90 h
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 s 0 0 0 0 hln 100 PROBEVAR=
a 0 a 0 0 4 22 hlb 100 LABEL=2
a 0 sp 0 0 0 0 hln 100 COLOR=BRIGHTRED
@conn
w 27
a 0 up 0:33 0 0 0 hln 100 V=
s 390 90 370 90 26
s 370 90 330 90 29
a 0 up 33 0 350 89 hct 100 V=
w 8
s 160 170 290 170 9
s 290 180 290 170 16
s 290 180 580 180 18
s 580 180 580 90 20
s 580 90 550 90 22
s 160 170 160 150 35
w 25
a 0 up 0:33 0 0 0 hln 100 V=
s 510 90 470 90 24
a 0 up 0:33 0 490 89 hct 100 V=
s 420 90 470 90 40
a 0 up 33 0 450 89 hct 100 V=
w 5
a 0 up 0:33 0 0 0 hln 100 V=
s 160 90 290 90 4
a 0 up 0:33 0 225 89 hct 100 V=
s 160 110 160 90 37
@junction
j 290 90
+ p 11 1
+ w 5
j 330 90
+ p 11 2
+ w 27
j 370 90
+ p 28 pin1
+ w 27
j 470 90
+ p 30 pin1
+ w 25
j 160 170
+ s 6
+ w 8
j 390 90
+ p 39 1
+ w 27
j 420 90
+ p 39 2
+ w 25
j 160 150
+ p 34 -
+ w 8
j 160 110
+ p 34 +
+ w 5
@attributes
a 0 s 0:13 0 0 0 hln 100 PAGETITLE=
a 0 s 0:13 0 0 0 hln 100 PAGENO=1
a 0 s 0:13 0 0 0 hln 100 PAGESIZE=A
a 0 s 0:13 0 0 0 hln 100 PAGECOUNT=1
@graphics

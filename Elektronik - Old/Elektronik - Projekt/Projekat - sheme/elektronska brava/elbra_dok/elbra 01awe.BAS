' Oleg Zastrizni - Elektronicka brava 0.1a '
' Razvojna verzija '
' Šifra - troznamenkasta >> 5231 '

Dim Rezultat As Byte , Petlja As Integer , Starel As Bit
Dim Pr_z As Bit , Dr_z As Bit , Tr_z As Bit , Ct_z As Bit , Kontrola As Integer , Pwr_dwn_kontrola As Integer


                P1 = &B11111111                               'postavljanje p1 porta u stanje mirovanja
                P3 = &B11111111                               'postavljanje p3 porta u stanje mirovanja
Zvjezdica Alias P3.4
  Ljestve Alias P1.4
    Jedan Alias P3.7
      Dva Alias P1.3
      Tri Alias P1.7
   Cetiri Alias P3.3
      Pet Alias P1.2
     Sest Alias P1.6
    Sedam Alias P3.5
     Osam Alias P1.1
    Devet Alias P1.5
     Nula Alias P1.0
    Relej Alias P3.1
   Indled Alias P1.4


Indled = 0
Waitms 800
Indled = 1

' provjera da li je zvjezdica pritisnuta          '
' ukoliko je pritisnuta omogucava se upis lozinke '

Starel = 0
Kontrola = 0
Pwr_dwn_kontrola = 0

'++++++++++++++ Cekanje pritiska zvijezdice >>> Oznacava pocetak unosa ++++++++'

Cekanje:

Indled = 1

Do
    'Indled = 0 : Waitms 50 : Indled = 1
    If Zvjezdica = 0 Then
    Incr Kontrola
    Goto Unos
    End If
    If Ljestve = 0 Then                                       ' Ako su pritisnute ljestve nakon unosa sifre
    Relej = 1                                                 ' relej se gasi
    Starel = 0
    End If
    Waitms 50

Loop

Unos:

  Zvjezdica = 1
' ukljuèivanje idikacijske diode '
  Indled = 0
' postavlja vrijednost rezultata za n znamenki mora biti n+1 na kraju za toèan unos'

 Indled = 0                                                   'idikacija za pripremu
 Waitms 50
 Indled = 1
 Waitms 50

 Wait 1
 Indled = 0

'++++++++++++ prva znamenka ++++++++++++
Jedan:

Pr_z = 0

For Petlja = 1 To 25000



If Pet = 0 Then                                               'zn1 - 5
   Pr_z = 1
Goto Dva
End If

Next Petlja
'++++++++++++ druga znamenka +++++++++++
Dva:
'Indled = 1 : Waitms 100 : Indled = 0
Dr_z = 0

For Petlja = 1 To 15000



If Dva = 0 Then                                               'zn2 - 2
   Dr_z = 1
   Goto Tri
   End If

   Next Petlja
'+++++++++++ treca znamenka ++++++++++++
Tri:
Tr_z = 0

For Petlja = 1 To 15000



If Tri = 0 Then                                               'zn3 - 3
    Tr_z = 1

    Goto Cetiri
    End If

    Next Petlja
'+++++++++++ cetvrta znamenka ++++++++++
Cetiri:
Ct_z = 0

For Petlja = 1 To 15000



If Jedan = 0 Then                                             'zn4 - 1
    Ct_z = 1

    Goto Zadnja
    End If

    Next Petlja

Zadnja:
'++++++++++++ Ukoliko je ispucano tri pokusaja idemo na blokiranje +++++++++++

If Kontrola = 3 Then
Goto Blokiranje
End If

' +++++++++++ provjera ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


 If Pr_z = 1 And Dr_z = 1 And Tr_z = 1 And Ct_z = 1 Then

  Pr_z = 0
  Dr_z = 0
  Tr_z = 0
  Ct_z = 0

  Kontrola = 0
  Pwr_dwn_kontrola = 0

  Indled = 1
  Waitms 100
  Indled = 0
  Waitms 25
  Indled = 1

  Goto Provjera
 End If

 Rezultat = 0

 Goto Cekanje

Provjera:

If Starel = 0 Then
 Starel = 1
 Relej = 0
 Goto Cekanje
 End If

If Starel = 1 Then
 Starel = 0
 Relej = 1
 Goto Cekanje
 End If

 Indled = 1
 Relej = 1
 End

'+++++++++++++++++++++++++++ Blokiranje ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Blokiranje:

Relej = 1
For Petlja = 1 To 50                                          ' koliko ponoviti perioda po 200 ms'
Indled = 0
Waitms 100
Indled = 1
Waitms 100
Next Petlja

Kontrola = 0                                                  'vracanje kontrole na pocetni položaj

Incr Pwr_dwn_kontrola

' ako se tri puta procesor blokira na odreðeno vrijeme
' procesor postaje mrtav i može se jedino ponovno pokrenuti
' pomoæu reset tipke

If Pwr_dwn_kontrola = 3 Then
Goto Pwr_dwn
End If

Goto Cekanje                                                  'povratak na cekanje

Pwr_dwn:

Powerdown

End
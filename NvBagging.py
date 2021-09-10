import csv
import sys
import random
import math
import statistics
import numpy as np

percobaan = 9;

trainset = 298;

def fitTxt(txt):
    l = txt.find(',')
    array = []
    if l == 0:
        array.append('')
    else:
        array.append(txt[:l])
    for k in range(len(txt)):
        if txt[k] != ',':
            pass
        else:
            if k == (len(txt)-1):
                array.append('')
            else:   
                if ',' in txt[(k+1):]:
                    koma = ','
                    kplus = (k+1)
                    p = txt.find(koma,kplus)
                    q = txt[(k+1):p]
                else:
                    q = txt[(k+1):]   
                array.append(q)
    return array

def createTpl(File): 
    fone = open(File, "r")
    tp = []
    next(fone)
    while 1:  
        txt = fone.readline()
        fix = []
        if txt == "":
            break
        else:
            pass

        if txt[-1] == '\n':
            txt = txt[:-1]
        else:
            pass

        array = fitTxt(txt)
        tp.append(array)

    return tp

def MeanStdev(a):

	total1=0
	total2=0
	arrayxa1=[]
	arrayxa2=[]
	array1x1=[]
	array1x2=[] 
	for k in a:
		if(k[2]==1):     
			arrayxa1.append(k[0])
			array1x1.append(k[1])
			total1 = total1 + 1
		elif(k[2]==2):
			arrayxa2.append(k[0])
			array1x2.append(k[1])
			total2 = total2 + 1


	mnstaticxa1 = statistics.mean(arrayxa1)
	mnstaticxa2 = statistics.mean(arrayxa2)
	mnstaticxb1 = statistics.mean(array1x1)
	mnstaticxb2 = statistics.mean(array1x2)
	
	stdevstaticxa1 = statistics.stdev(arrayxa1)
	stdevstaticxa2 = statistics.stdev(arrayxa2)
	stdevstaticxb1 = statistics.stdev(array1x1)
	stdevstaticxb2 = statistics.stdev(array1x2)

	ra1 = {'Rata-Rata':mnstaticxa1,'Nilai Stdev':stdevstaticxa1,'jumlah':total1}
	rb1 = {'Rata-Rata':mnstaticxb1,'Nilai Stdev':stdevstaticxb1,'jumlah':total1}
	ra2 = {'Rata-Rata':mnstaticxa2,'Nilai Stdev':stdevstaticxa2,'jumlah':total2}
	rb2 = {'Rata-Rata':mnstaticxb2,'Nilai Stdev':stdevstaticxb2,'jumlah':total2}

	hasil = []
	hasil.append(ra1)
	hasil.append(rb1)
	hasil.append(ra2)
	hasil.append(rb2)

	return hasil	

def norm(a,b,c):

    vr = float(c)**2
    den = (2*math.pi*vr)**.5
    nm = math.exp(-(float(a)-float(b))**2/(2*vr))

    return nm/den

def decide(a,b):

    if(a>b):
        return -1
    else:
        return 1

def Nvbayes(a,b):

	xa0 = a[0]
	xa1 = a[1]
	totalb0 = b[0]['jumlah']
	totalb1 = b[1]['jumlah']
	rataxb0 = b[0]['Rata-Rata']
	rataxb1 = b[1]['Rata-Rata']
	rataxb2 = b[2]['Rata-Rata']
	rataxb3 = b[3]['Rata-Rata']
	stdevx0 = b[0]['Nilai Stdev']
	stdevx1 = b[1]['Nilai Stdev']
	stdevx2 = b[2]['Nilai Stdev']
	stdevx3 = b[3]['Nilai Stdev']
	normpratax1 = norm(xa0,rataxb0,stdevx0)
	normpratax2 = norm(xa0,rataxb1,stdevx1)
	normprata1x1 = norm(xa1,rataxb2,stdevx2)
	normprata1x2 = norm(xa1,rataxb3,stdevx3)
	normptotalx1 = totalb0/trainset
	normptotalx2 = totalb1/trainset
	ein = normpratax1 * normprata1x1 * normptotalx1
	zwei = normpratax2 * normprata1x2 * normptotalx2
	ret = decide(ein,zwei)

	return ret

dt2 = createTpl('TestsetTugas4ML.csv')
dt1 = np.array(createTpl('TrainsetTugas4ML.csv'))
dt4 = dt1
dtTrain = dt1.astype(np.float) 
rowTrain = len(dtTrain) - 1


for k in dt2:
	k.pop() 

dt3 = np.array(dt2)
dt4 = dt3
dtTest = dt3.astype(np.float) 

boosting = []

for k in range(percobaan):
	nw = []

	for l in range(trainset):
		randx = random.randint(0,rowTrain)
		nw.append(dtTrain[randx])

	boosting.append(nw)

mnStdev = []

for k in range(percobaan):
	mnStdev.append(MeanStdev(boosting[k]))

hsl = []

for k in dtTest:
	sm = 0

	for l in mnStdev:
		sm = sm + Nvbayes(k,l)

	if(sm>0): hsl.append(2)
	else: hsl.append(1)

hsl = np.array(hsl)

with open('TebakanTugas4ML.csv', "w", newline='') as csvfile:
	writer = csv.writer(csvfile, delimiter=',')
	for array in range(0,hsl.shape[0]):
		array2 = []
		array2.append(hsl[array])
		writer.writerow(array2)

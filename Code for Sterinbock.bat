#1. Run sterinbock
doskey steinbock=docker run -p 8888:8888 -v "D:\Data_steinbock":/data ghcr.io/bodenmillergroup/steinbock:0.16.1 $* 

#2. Extract individual IMC acquisitions 
steinbock preprocess imc images --hpf 50

#3. Image segmentation
steinbock segment deepcell --minmax
#note: if you want to correct mask file in cellpose, please transform the file into .tiff by fiji.

#4. Single-cell data extraction
steinbock measure intensities
steinbock measure regionprops
steinbock measure neighbors --type expansion --dmax 4

#!/bin/bash

if [[ -z $1 ]]; then echo -e "\n\tUsage:\t\t$0 <option>\n"; exit 1; fi

if [[ $1 == merge ]]; then
    javac src/mergesort/*.java && java -cp ./src mergesort.MergeSort
elif [[ $1 == insert ]]; then
    javac src/insertionsort/*.java && java -cp ./src insertionsort.InsertionSort
else
    exit 2;
fi

exit 0;

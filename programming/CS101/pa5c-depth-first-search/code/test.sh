#!/bin/bash

count=1
for i in $( ls in[1-6] ); do
   FindComponents $i out$(( $count + 6 ))
   diff out$count out$(($count + 6))
   ((count += 1))
done

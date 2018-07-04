import random

file = open("10000.txt", 'w')

for i in range(10000):
    line = str(random.randint(1, 10000)) + "\n"
    file.write(line)

file.close()

            

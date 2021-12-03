#Create a list of names
names = ["James", "John", "David", "Kevin", "Sean", "Frank"]

#Loop to prompt for height and weight
ht = []
wt = []
for i in names:
    ht.append(eval(input(f"What is the height in inches for {i}: ")))
    wt.append(eval(input(f"What is the weight in pounds for {i}: ")))

#Make a function that calculates BMI wt * 703 / ht**2
bmi = []
def BMI(x, y):
    for num1, num2 in zip(x,y):
        bmi.append(round(((num1 * 703) / num2**2),2))
BMI(wt, ht)

#Show who is under, normal or overweight and the number of under weight, normal weight, or over weight
def final(a,b):
    i = 0
    under = []
    normal = []
    over = []
    while i < len(a):
        if b[i] <= 18.5:
            print(f"{a[i]} is underweight.")
            under.append(b[i])
            i += 1
        elif b[i] >= 18.6 and b[i] <= 24.9:
            print(f"{a[i]} is within healthy weight range.")
            normal.append(b[i])
            i += 1
        else:
            print(f"{a[i]} is overweight.")
            over.append(b[i])
            i += 1
    print(f"There are {len(under)} underweight, {len(normal)} normal weight, and {len(over)} overweight people.")
final(names, bmi)

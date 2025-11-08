text = 'Here is the solution to the riddle:\n' +
    '\n' +
    '1. Frank Underwood drinks Champagne.\n' +
    '2. Frank Underwood smokes Slow Death.\n' +
    '3. Frank Underwood lives in 4 with colour Red.\n' +
    '4. Frank Underwood has pet Shark.\n' +
    '\n' +
    '5. Dr. Evil drinks Whiskey.\n' +
    '6. Dr. Evil smokes Black Lung.\n' +
    '7. Dr. Evil lives in 3 with colour Black.\n' +
    '8. Dr. Evil has pet Octopus.\n' +
    '\n' +
    '9. Donald Trump drinks Bourbon.\n' +
    '10. Donald Trump smokes French Soot.\n' +
    '11. Donald Trump lives in 2 with colour Brown.\n' +
    '12. Donald Trump has pet Armadillo.\n' +
    '\n' +
    '13. Bane drinks Tequila.\n' +
    '14. Bane smokes Coal Dust.\n' +
    '15. Bane lives in 1 with colour White.\n' +
    '16. Bane has pet Cyborg Tortoise.\n' +
    '\n' +
    '17. Kim Jong-un drinks Vodka.\n' +
    '18. Kim Jong-un smokes Hacking Cough.\n' +
    '19. Kim Jong-un lives in 5 with colour Blue.\n' +
    '20. Kim Jong-un has pet Robot Chicken. '

text = text.split("\n").map(l => l.trim()).filter(line => line.length > 0 && /^\d+$/.test(line.charAt(0))).join("\n")
console.log(text)
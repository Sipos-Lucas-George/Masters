var text = '' +
    'Here are 10 ironic XYZ constructions within the world of sport:\n' +
    '\n' +
    '1. **Flopping in soccer is the Method Acting of professional fouls.** (Z: professional fouls, Y: Method Acting, X: Flopping in soccer)\n' +
    '\n' +
    '2. **E-sports commentators are the Wagner of button mashing.** (Z: button mashing, Y: Wagner (operatic composer), X: E-sports commentators)\n' +
    '\n' +
    '3. **Zorbing is the existentialism of downhill rolling.** (Z: downhill rolling, Y: existentialism, X: Zorbing)\n' +
    '\n' +
    '4. **Post-game interviews are the haiku of athletic expression.** (Z: athletic expression, Y: haiku, X: Post-game interviews)\n' +
    '\n' +
    '5. **Fantasy football drafts are the Yalta Conference of suburban basements.** (Z: suburban basements, Y: Yalta Conference, X: Fantasy football drafts)\n' +
    '\n' +
    '6. **Synchronized swimming is the Busby Berkeley of aquatic athleticism.** (Z: aquatic athleticism, Y: Busby Berkeley (film choreographer), X: Synchronized swimming)\n' +
    '\n' +
    '7. **The Designated Hitter rule is the Dadaism of baseball strategy.** (Z: baseball strategy, Y: Dadaism, X: The Designated Hitter rule)\n' +
    '\n' +
    '8. **Sports car racing is the ballet of internal combustion.** (Z: internal combustion, Y: ballet, X: Sports car racing)\n' +
    '\n' +
    '9. **CrossFit is the Stoicism of physical exertion.** (Z: physical exertion, Y: Stoicism, X: CrossFit)\n' +
    '\n' +
    '10. **Performance-enhancing drugs are the shortcut of athletic achievement.** (Z: athletic achievement, Y: shortcut, X: Performance-enhancing drugs – with a touch of ironic understatement)'

function process(response) {
    text = response.text.split("\n").map(line => line.trim()).filter(line => line.length > 0)
    title1 = text[0].split(" ")
    label1 = title1[0].trim()
    column = title1[1].trim()
    column = column.charAt(0).toUpperCase() + column.slice(1)
    text = text.slice(2)
    separatorIndex = text.findIndex(line => /^-+$/.test(line))
    title2 = text[separatorIndex - 1].split(" ")
    label2 = title2[0].trim()

    section1 = text.slice(0, separatorIndex - 1).map(line => `${line}\t${label1}`)
    section2 = text.slice(separatorIndex + 1).map(line => `${line}\t${label2}`)
    return `${column}\tExpected\n` + section1.concat(section2).join("\n")
}

text = text.split("\n").map(l => l.trim()).filter(line => line.length > 0 && /^\d+$/.test(line.charAt(0)))
text = text.map(l => {
    let i1 = l.indexOf("**") + 2
    let i2 = l.substring(i1).indexOf("**")
    return l.substring(i1, i1 + i2)
})
console.log(text.join("\n"))

var x = "60,5".split(",")
console.log()


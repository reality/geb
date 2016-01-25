Articles = [ 'the', 'a', 'an' ]
Adjectives = [ 'fluffy', 'scary', 'fishy', 'repugnant' ]
Nouns = [ 'wizard', 'toothpaste', 'fish' ]
Verbs = [ 'swims', 'fights', 'eats' ]
Prepositions = [ 'above', 'to', 'beyond', 'past', 'despite', 'alongside' ]
RelativePronouns = [ 'that', 'when', 'which', 'whichever', 'whichsoever', 'who', 'whoever', 'whosoever', 'whom', 'whose', 'whatever' ]

import java.util.Random
rand = new Random()

def fancyNoun() {
  def newFancyNoun = ornateNoun()

  def choice = rand.nextInt(3) 
  if(choice == 0) {
    return newFancyNoun + ' ' + relativePronoun()
  } else if(choice == 1) {
    return newFancyNoun + ' ' + preposition() + ' ' + fancyNoun()
  } else if(choice == 2) {
    return newFancyNoun
  }
}

def ornateNoun() {
  def choice = rand.nextInt(3) 
  if(choice == 0) {
    return article()
  } else if(choice == 1) {
    return adjective()
  } else if(choice == 2) {
    return noun()
  }
}

def preposition() {
  return Prepositions[rand.nextInt(Prepositions.size())]
}

def verb() {
  return Verbs[rand.nextInt(Verbs.size())]
}

def relativePronoun() {
  def newRelativePronoun = RelativePronouns[rand.nextInt(RelativePronouns.size())]

  def choice = rand.nextInt(2)
  if(choice == 0) {
    return newRelativePronoun + ' ' + verb() + ' ' + fancyNoun()
  } else if(choice == 1) {
    return newRelativePronoun + ' ' + fancyNoun() + ' ' + verb()
  }
}

def article() {
  def newArticle = Articles[rand.nextInt(Articles.size())]

  def choice = rand.nextInt(2)
  if(choice == 0) {
    return newArticle + ' ' + adjective()
  } else if(choice == 1) {
    return newArticle + ' ' + noun()
  }
}

def adjective() {
  def newAdjective = Adjectives[rand.nextInt(Adjectives.size())]

  def choice = rand.nextInt(2)
  if(choice == 0) {
    return newAdjective + ' ' + adjective()
  } else if(choice == 1) {
    return newAdjective + ' ' + noun()
  }
}

def noun() {
  def newNoun = Nouns[rand.nextInt(Nouns.size())]

  def choice = rand.nextInt(2)
  if(choice == 0) {
    return newNoun
  } else if(choice == 1) {
    return newNoun + ' ' + article()
  }
}

println fancyNoun()

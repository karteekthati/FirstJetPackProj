package kk.compose.firstjetpackproj.ui.viewmodels

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel() {

    fun generateRandomFact(selectedAnimal: String): String =
        (if (selectedAnimal == "Dog") getDogFacts() else getCatFacts()).random()


    private fun getDogFacts(): List<String> {
        return listOf(
            "1. Dogs are descendants of wolves.",
            "2. The Basenji dog is known as the 'barkless dog' because it doesn't bark like other dogs.",
            "3. A dog's sense of smell is 10,000 to 100,000 times more sensitive than humans.",
            "4. Dalmatians are born completely white and develop their spots as they grow older.",
            "5. Greyhounds are one of the fastest dog breeds and can run up to 45 miles per hour."
        )
    }

    private fun getCatFacts(): List<String> {
        return listOf(
            "1. Cats sleep for about 70% of their lives.",
            "2. The world's oldest cat lived to be 38 years old.",
            "3. Cats have a strong territorial instinct.",
            "4. A group of cats is called a 'clowder.'",
            "5. Cats have retractable claws, which help them keep them sharp."
        )
    }

}
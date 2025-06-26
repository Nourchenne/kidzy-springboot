document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');
    const errorMsg = document.getElementById('errorMsg');
    const successMsg = document.getElementById('successMsg');
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');

    // Animation panneau
    if (signUpButton && signInButton && container) {
        signUpButton.addEventListener('click', () => {
            container.classList.add('right-panel-active');
        });

        signInButton.addEventListener('click', () => {
            container.classList.remove('right-panel-active');
        });
    }

    // Formulaire de connexion
    if (loginForm) {
        loginForm.addEventListener('submit', async (event) => {
            event.preventDefault();

            const email = document.getElementById('email').value.trim();
            const password = document.getElementById('password').value.trim();
            errorMsg.style.display = 'none';
            successMsg.style.display = 'none';
            errorMsg.textContent = "";

            if (!email || !password) {
                errorMsg.textContent = "Veuillez remplir tous les champs.";
                errorMsg.style.display = 'block';
                return;
            }

            try {
                const response = await fetch('/api/auth/login', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ email, password })
                });

                if (!response.ok) {
                    const errorText = await response.text();
                    errorMsg.textContent = errorText || "Email ou mot de passe invalide.";
                    errorMsg.style.display = 'block';
                    return;
                }

                const data = await response.json();
                successMsg.style.display = 'block';

                setTimeout(() => {
                    if (data.role === 'parent') {
                        window.location.href = 'hparent.html';
                    } else if (data.role === 'babysitter') {
                        window.location.href = 'hsitter.html';
                    } else {
                        errorMsg.textContent = "Rôle utilisateur inconnu.";
                        errorMsg.style.display = 'block';
                    }
                }, 1000);
            } catch (error) {
                console.error('Erreur:', error);
                errorMsg.textContent = "Erreur serveur, veuillez réessayer plus tard.";
                errorMsg.style.display = 'block';
            }
        });
    }
});

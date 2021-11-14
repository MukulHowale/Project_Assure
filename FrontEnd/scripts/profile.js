let userId = JSON.parse(localStorage.getItem("UserID"));
let bookings = document.getElementById('bookings');

async function loadBookings() {
    
    // userId = 2;
    let a  = await fetch(`http://localhost:8070/bookings/${userId}`);
    let b = await a.json();
    localStorage.setItem("PolicyBookings", JSON.stringify(b));

    for (let {policyName, coverAmount, validTillDate} of b) {
        let card = document.createElement('div');
        card.innerHTML = `<div class="bookingCard"><p class="policyName">
                    ${policyName}
                </p>
                <p class="product_title">
                    Product
                </p>
                <p class="insurance_type">
                    Health Insurance
                </p>
                <div class="cover_block">
                    <span>
                        <p class="cover_title">
                            Cover
                        </p>
                        <p class="cover_amount">
                            Rs. ${coverAmount}
                        </p>
                    </span>
                    <span class="left_valid">
                        <p class="valid_title">
                            Valid till
                        </p>
                        <p class="valid_thru">
                            ${validTillDate.substring(0, 10)}
                        </p>
                    </span>
                </div>
                <div class="details_div">
                    <p class="view_details">
                        View Details
                    </p>
                    <img src="../icons/detail.svg" alt="" class="detail_arrow">
                </div></div>`;
        bookings.appendChild(card);

    }
}

window.onload = loadBookings();


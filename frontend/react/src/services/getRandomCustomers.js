import axios from "axios";

export const getRandomUsers = async (gender) => {
    try {
        const response =  await axios.get(`https://randomuser.me/api/?gender=${gender}`);
        return response.data.results[0].picture["large"]

    } catch (error){
        console.log(error);
        throw new Error("Failed to fetch random user.");
    }
}


require("../solution")

local num_test = 30
local in_0 = {}
local in_org_0 = {}
local in_1 = {}
local in_org_1 = {}
local out = {}


function load_test()
    local f = io.open("./judge/tests/query-intervals-2.txt", "r")
    in_0 = read_interval_matrix(f)
    in_org_0 = copy(in_0)
    in_1 = read_num_array(f)
    in_org_1 = copy(in_1)
    out = read_interval_matrix_arr(f)
    f:close()
end

function judge()
    load_test()

    local start = os.clock()
    for i = 1, num_test do
        local inte = clone(Intervals, {})
        inte:preprocess(in_0[i])
        for j = 1, in_1[i]-1 do
            local answer = inte:query(j)
            if not equals(answer,out[i][j+1]) then
                io.write(string.format("%d / %d;", i, num_test))
                io.write(to_string(in_org_0[i]) .. ", " .. j)
                io.write(";")
                io.write(to_string(answer))
                io.write(";")
                io.write(to_string(out[i][j+1]))
                io.write("\n")
                return
            end
        end
    end

    local elapsed = math.floor((os.clock() - start) * 1000)
	print("Accepted;" .. elapsed)
end
